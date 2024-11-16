import { DialogBody, DialogContent, DialogFooter, DialogHeader, DialogRoot, DialogTitle, DialogTrigger, IconButton, Input } from "@chakra-ui/react";
import { Form, Formik } from "formik";
import { useRef } from "react";
import { IoMdLogIn } from "react-icons/io";
import { Button } from "../ui/button";
import { DialogCloseTrigger } from "../ui/dialog";
import { useStoreActions } from "easy-peasy";

const ModalLogin = () => {
    const initialValues = {
        email: "",
        password: ""
    }

    const ref = useRef<HTMLInputElement>(null);
    const inputToken = useStoreActions<any>((actions)=>actions.inputToken);


    return (
    <Formik
    initialValues={initialValues}
    onSubmit={async (values)=>{
        try {
            const response = await fetch("http://localhost:8080/auth/login", {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify(values),
            });
      
            if (!response.ok) {
              throw new Error("Erro ao fazer login");
            }
      
            const data = await response.json();
            console.log(data);
            const token = data.token;
      
            inputToken(token);
          } catch (error) {
            console.error("Erro ao fazer login:", error);
          }
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
                    >
                <DialogTrigger asChild>
                    <IconButton color="white" aria-label="login">
                        <IoMdLogIn />
                    </IconButton>       
                </DialogTrigger>
                    <DialogContent >
                    <DialogHeader>
                    <DialogTitle>Login</DialogTitle>
                    </DialogHeader>
                    <DialogBody >
                            <Input {...getFieldProps('email')} name="email" placeholder="Usuário" />
                            <Input {...getFieldProps('password')} name="password" type="password" placeholder="Senha" />
                    </DialogBody>
                    <DialogFooter>
                        <Button color="white" textTransform="uppercase">Cadastrar</Button>
                        <Button color="white" type="submit" textTransform="uppercase">Entrar</Button>
                    </DialogFooter>
                    <DialogCloseTrigger />
                </DialogContent>
            </DialogRoot>
            </Form>
        )}
       
    </Formik>
    );

}

export default ModalLogin;