import { Box, DialogBody, DialogContent, DialogFooter, DialogHeader, DialogRoot, DialogTitle, DialogTrigger, IconButton, Input, Portal } from "@chakra-ui/react";
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
                    <Portal>
                        <DialogContent >
                            <DialogHeader>
                            <DialogTitle>Login</DialogTitle>
                            </DialogHeader>
                            <DialogBody >
                                    <Input {...getFieldProps('email')} name="email" placeholder="Email" />
                                    <Input {...getFieldProps('password')} name="password" type="password" placeholder="Senha" />
                            </DialogBody>
                            <DialogFooter>
                            <DialogActionTrigger asChild>
                                <Button color="white" onClick={()=>{
                                    setLoginPage(false)
                                    setRegisterPage(true)
                                    }} textTransform="uppercase">Cadastrar</Button>
                            </DialogActionTrigger>
                                <Button color="white" type="submit" textTransform="uppercase">Entrar</Button>
                            </DialogFooter>
                            <DialogCloseTrigger onClick={()=>setLoginPage(false)} />
                        </DialogContent>
                    </Portal>
                </DialogRoot>
                </Form>
            )}
        
        </Formik>
    </Box>
    );

}

export default ModalLogin;