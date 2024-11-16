import { Box, Button, Flex } from "@chakra-ui/react";
import { CardList, CardProps } from "../item/CardList";
import { useLocation, useNavigate } from "react-router-dom";
// AIzaSyBNvPR9hxR2Z7R1Pe2rRoUR0V9DMplHwh8
const ResultPage = () => {
    const location = useLocation();
    const { state } = location as {state: {listResult: CardProps[]}};
    const navigate = useNavigate();
    return (
        <Box>
            <Button  onClick={()=>navigate("/submission-form")}>Voltar</Button>
            <Flex wrap={"wrap"} gap={"2rem"}>
                {state?.listResult.map((item, index) => (
                    <CardList key={index} {...item} />
                ))}
            </Flex>
        </Box>
    );
};

export default ResultPage;