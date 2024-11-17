import { Box } from "@chakra-ui/react";
import { useState } from "react";
import ModalLogin from "./ModalLogin";
import ModalRegister from "./ModalRegister";

const HeaderPage = () =>{

    const [loginPage, setLoginPage] = useState<boolean>(false);
    const [registerPage, setRegisterPage] = useState<boolean>(false);


    return (<Box>
        <ModalRegister registerPage={registerPage} setRegisterPage={setRegisterPage} setLoginPage={setLoginPage} />
        <ModalLogin loginPage={loginPage} setRegisterPage={setRegisterPage} setLoginPage={setLoginPage}/>
    </Box>);

}

export default HeaderPage;