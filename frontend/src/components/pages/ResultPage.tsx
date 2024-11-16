import { Box, Button, Flex } from "@chakra-ui/react";
import { CardList, CardProps } from "../item/CardList";
import { useNavigate } from "react-router-dom";

interface ResultPageProps {
    listResult: CardProps[];
}

// const ResultPage: React.FC<ResultPageProps | null> = ({ listResult }) => {
const ResultPage = () => {
    const testeImagem = {
        src: "https://wallpapers.com/images/high/goku-pictures-im28xdck0mbth703.webp",
        alt: "goku vermei",
        title: "GOKU VERMEI",
        description: "TESTANDO O GOKU VERMEI"
    } 
    const listResult = Array.from({length: 5}, () => testeImagem);
    const navigate = useNavigate();
    return (
        <Box>
            <Button  onClick={()=>navigate("submission-form")}>Voltar</Button>
            <Flex wrap={"wrap"} gap={"2rem"}>
                {listResult.map((item, index) => (
                    <CardList key={index} {...item} />
                ))}
            </Flex>
        </Box>
    );
};

export default ResultPage;