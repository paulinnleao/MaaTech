import logoMaatech from "@/components/utils/iconMaaTech.png";
import { Box, DialogBody, DialogContent, DialogFooter, DialogHeader, DialogRoot, DialogTitle, DialogTrigger, IconButton, Image, Input, Portal } from "@chakra-ui/react";
import { Form, Formik } from "formik";
import { useRef } from "react";
import { IoMdLogIn } from "react-icons/io";
import { Button } from "../ui/button";
import { DialogActionTrigger, DialogCloseTrigger } from "../ui/dialog";
import { useEndpoints } from "../utils/useEndpoints";

interface ModaloginPageProps {
    loginPage: boolean;
    setLoginPage: React.Dispatch<React.SetStateAction<boolean>>;
    setRegisterPage: React.Dispatch<React.SetStateAction<boolean>>;
}

const ModalLogin: React.FC<ModaloginPageProps>= ({loginPage, setRegisterPage, setLoginPage}) => {
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
    const {endLogin} = useEndpoints();
    const initialValues = {
        email: "",
        password: ""
    }
    const ref = useRef<HTMLInputElement>(null);
    return (
        <Box>
        <Formik
        initialValues={initialValues}
        onSubmit={(values)=> {
            endLogin(values);
            setLoginPage(false);
        }}
        >
            {({handleSubmit, getFieldProps})=>(
                <Form onSubmit={handleSubmit}>
                    <DialogRoot 
                    motionPreset="slide-in-left"
                    placement="top" 
                    role="alertdialog"
                    initialFocusEl={() => ref.current}
                    size="lg"
                    open={loginPage}
                        >
                    <DialogTrigger asChild>
                        <IconButton alignItems="center" onClick={()=>setLoginPage(true)} backgroundColor="#F0F8FF" aria-label="login">
                            <IoMdLogIn />
                        </IconButton>       
                    </DialogTrigger>
                        <DialogContent color="black" backgroundColor={"#F0F8FF"}  >
                            <DialogHeader display="flex" alignItems="center" margin={"auto"}>
                                
                            <IconButton  backgroundColor={"#F0F8FF"} >
                                <Image borderRadius="full" boxSize={"10"} src={logoMaatech} />
                            </IconButton>
                            <DialogTitle>MaaTech</DialogTitle>
                            </DialogHeader>
                            <DialogBody display="flex" flexDir="column" gap={"2rem"} >
                                    <Input {...getFieldProps('email')} textAlign={"center"} name="email" placeholder="Email" />
                                    <Input {...getFieldProps('password')} textAlign={"center"} name="password" type="password" placeholder="Senha" />
                            </DialogBody>
                            <DialogFooter>
                            <DialogActionTrigger asChild>
                                <Button {...styleButtonMenu}  onClick={()=>{
                                    setLoginPage(false)
                                    setRegisterPage(true)
                                    }} textTransform="uppercase">Cadastrar</Button>
                            </DialogActionTrigger>
                                <Button {...styleButtonMenu} type="submit" textTransform="uppercase">Entrar</Button>
                            </DialogFooter>
                            <DialogCloseTrigger color={"black"} onClick={()=>setLoginPage(false)} />
                        </DialogContent>
                </DialogRoot>
                </Form>
            )}
        
        </Formik>
        
    </Box>
    );

}

export default ModalLogin;