import logoMaatech from "@/components/utils/iconMaaTech.png";
import { Flex, IconButton, Image, Stack, Text } from "@chakra-ui/react";
import { useState } from "react";
import ModalLogin from "./ModalLogin";
import ModalRegister from "./ModalRegister";

const HeaderPage = () =>{

    const [loginPage, setLoginPage] = useState<boolean>(false);
    const [registerPage, setRegisterPage] = useState<boolean>(false);

    return (
    <Stack height="62.5px">
        <Flex alignItems="center" paddingLeft="150px">
            <IconButton  backgroundColor={"#F0F8FF"} >
                <Image borderRadius="full" boxSize={"10"} src={logoMaatech} />
            </IconButton>

            <Text paddingLeft="10px" fontSize="4xl" color="#1491DC">MaaTech</Text>
        
            <ModalRegister registerPage={registerPage} setRegisterPage={setRegisterPage} setLoginPage={setLoginPage} />
            <ModalLogin loginPage={loginPage} setRegisterPage={setRegisterPage} setLoginPage={setLoginPage}/>
        </Flex>
        <hr style={{borderColor:"#DC8A14"}} />
    </Stack>);

}

export default HeaderPage;