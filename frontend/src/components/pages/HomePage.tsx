import { useNavigate } from "react-router-dom";
import { Button } from "../ui/button";

const HomePage = () =>{

    const navigate = useNavigate();

    return <>
        <Button
            color={"white"}
            onClick={()=>navigate("/submission-form")}
        >
            Buscar Item
        </Button>
        <Button 
            color={"white"}
            onClick={()=>navigate("/user-list")}>
            Ver Lista de Itens
        </Button>
    </>
}

export default HomePage;