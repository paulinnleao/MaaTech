import { Box, Button, Flex } from "@chakra-ui/react";
import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { CardList } from "../item/CardList";
import { ItemBodyProps } from "../item/ModalProduct";
import { useEndpoints } from "../utils/useEndpoints";
// AIzaSyBNvPR9hxR2Z7R1Pe2rRoUR0V9DMplHwh8

const ResultPage = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const {useAssembleTheItemBody} = useEndpoints();

    const { state } = location as {state: {listResult: string[]}};
    const [listProducts, setListProducts] = useState<ItemBodyProps[]>([]);

    const delay = (ms: number) => new Promise(resolve => setTimeout(resolve, ms));

    useEffect(() => {
        const fetchProductsWithDelay = async () => {
            const results: ItemBodyProps[] = [];
    
            for (const product of state.listResult) {
                const result = await useAssembleTheItemBody(product);
                if (result) results.push(result);
                await delay(500);
            }
    
            setListProducts(results);
        };
    
        fetchProductsWithDelay();
    }, [state.listResult, useAssembleTheItemBody]);

    return (
        <Box>
            <Button color="white"  onClick={()=>navigate("/submission-form")}>Voltar</Button>
            <Flex wrap={"wrap"} gap={"2rem"}>
                {listProducts.map((item, index) => (
                    <CardList key={index} {...item} />
                ))}
            </Flex>
        </Box>
    );
};

export default ResultPage;