import { useNavigate } from "react-router-dom";

const HomePage = () =>{

    const navigate = useNavigate();

    return <>
        <button
            onClick={()=>navigate("submission-form")}
        >
            Buscar Item
        </button>
        <button>
            Ver Lista de Itens
        </button>
    </>
}

export default HomePage;