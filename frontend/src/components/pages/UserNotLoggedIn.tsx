import { Box, Text } from "@chakra-ui/react";
import { Button } from "../ui/button";
import { useNavigate } from "react-router-dom";

const UserNotLoggedIn = () => {

    const navigate = useNavigate();

    return (
        <Box>
            <Text>Usuário não logado!</Text>
            <Button color={"white"} onClick={()=>navigate("/")} > Menu Inicial </Button>
        </Box>
    );

}

export default UserNotLoggedIn;