import { useNavigate } from "react-router-dom";
import { Button } from "../ui/button";
import { useStoreState } from "easy-peasy";
import { useEndpoints } from "../utils/useEndpoints";
import { Box, Center, Flex, Text } from "@chakra-ui/react";
import { FaRegBookmark, FaSearch } from "react-icons/fa";

const HomePage = () =>{
    const logado = useStoreState((state: any) => state.token);
    const navigate = useNavigate();
    const {notifyError} = useEndpoints();

    const styleButtonMenu = {
        display:"flex",
        justifyContent:"space-between",
        backgroundColor:"#1491DC",
        padding:"20px 35px",
        alignItems:"center",
        width:"15rem",
        borderRadius:"5px",
        cursor: "pointer"
    }

    return <>
    <Center height="calc(100vh - 62.5px)" gap="150px">
        <Button
            color={"white"}
            onClick={()=>navigate("/submission-form")}
            {...styleButtonMenu}
        >
            <Text textStyle="lg" >Buscar Produto</Text>
            <FaSearch />
        </Button>
        <Button 
            color={"white"}
            onClick={()=>{
                (!!logado)
                ? navigate("/user-list")
                : notifyError("Usuário Não Logado!") ;
            }}
            {...styleButtonMenu}
            >
                <Text textStyle="lg">Produtos Salvos</Text>
            <FaRegBookmark />
        </Button>
    </Center>
    </>
}

export default HomePage;