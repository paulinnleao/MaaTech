import logoMaatech from "@/components/utils/iconMaaTech.png";
import { Button, DialogBody, DialogCloseTrigger, DialogContent, DialogFooter, DialogHeader, DialogRoot, DialogTitle, IconButton, Image, Input } from "@chakra-ui/react";
import { Form, Formik } from "formik";
import React, { useRef } from "react";
import { Bounce, toast } from "react-toastify";
import { DialogActionTrigger } from "../ui/dialog";
import { useEndpoints } from "../utils/useEndpoints";
import { useStoreState } from "easy-peasy";

interface ModalRegisterPageProps {
    registerPage: boolean;
    setRegisterPage: React.Dispatch<React.SetStateAction<boolean>>;
    setLoginPage: React.Dispatch<React.SetStateAction<boolean>>;
    
}
const styleButtonMenu = {
    display:"flex",
    backgroundColor:"#1491DC",
    padding:"20px 35px",
    alignItems:"center",
    width:"8rem",
    borderRadius:"5px",
    cursor: "pointer",
    color: "white"
}

const ModalRegister: React.FC<ModalRegisterPageProps> = ({registerPage, setRegisterPage, setLoginPage}) =>{
    const {endLogin, endRegister} = useEndpoints();
    const logado = useStoreState((state: any) => state.token);
    const notifySuccess = (text: string) => toast.success(text, {
        position: "bottom-center",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "dark",
        transition: Bounce,
        });
    const notifyError = (text: string) => toast.error(text, {
        position: "bottom-center",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "dark",
        transition: Bounce,
        });
    const ref = useRef<HTMLInputElement>(null);
    const initialValues = {
        name: "",
        email: "",
        password: ""
    }

    const handleSubmit = async (values: { name: string; email: string; password: string }) => {
        try {
          const register = await endRegister(values);
          if (register) {
            console.log("first")
            notifySuccess("Cadastro realizado com sucesso!");
            await endLogin(values);
            setLoginPage(true);
          } else {
            notifyError("Erro ao realizar cadastro!");
            throw new Error("Erro ao fazer login");
          }
        } catch (error) {
          console.error("Erro ao registrar:", error);
          notifyError("Erro ao processar a solicitação.");
        }
      };

    return (<>
        {!!logado 
        ? <>  </>
        : <Formik
            initialValues={initialValues}
            onSubmit={handleSubmit}
            >
            {({handleSubmit, getFieldProps})=>(
                <Form onSubmit={handleSubmit}>
                    <DialogRoot 
                    motionPreset="slide-in-left"
                    placement="top" 
                    role="alertdialog"
                    initialFocusEl={() => ref.current}
                    size="lg"
                    open={registerPage}
                        >
                        <DialogContent color="black" backgroundColor={"#F0F8FF"}>
                        <DialogHeader display="flex" alignItems="center" margin="auto">
                        <IconButton  backgroundColor={"#F0F8FF"} >
                            <Image borderRadius="full" boxSize={"10"} src={logoMaatech} />
                        </IconButton>
                        <DialogTitle>Realizar Cadastro</DialogTitle>
                        </DialogHeader>
                        <DialogBody display="flex" flexDir="column" gap={"1rem"} >
                                <Input {...getFieldProps('name')} name="name" placeholder="Nome" />
                                <Input {...getFieldProps('email')} name="email" placeholder="Email" />
                                <Input {...getFieldProps('password')} name="password" type="password" placeholder="Senha" />
                        </DialogBody>
                        <DialogFooter>
                            <DialogActionTrigger asChild>
                                <Button {...styleButtonMenu} onClick={()=>{
                                    setRegisterPage(false)
                                }} textTransform="uppercase">Cancelar</Button>
                            </DialogActionTrigger>
                            <Button {...styleButtonMenu} type="submit" textTransform="uppercase">Cadastrar</Button>
                        </DialogFooter>
                        <DialogCloseTrigger color="black" onClick={()=>{setRegisterPage(false)}} />
                    </DialogContent>
                </DialogRoot>
            </Form>
            )}
        </Formik>}
    </> );
}

export default ModalRegister;