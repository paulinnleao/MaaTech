import { Box, Button, Flex } from "@chakra-ui/react";
import { CardList, CardProps } from "../item/CardList";
import { useLocation, useNavigate } from "react-router-dom";
// AIzaSyBNvPR9hxR2Z7R1Pe2rRoUR0V9DMplHwh8

// model: string;
// brand: string;
// avaragePrice: number;
// category: string;
// rating: string;
// reviewCount: string;
// weight: string;
// cardProps: CardProps;
// src: string;
// alt: string;
// title: string;
// description: string;

const searchImage = async (product: string): Promise<string | undefined> => {
    try {
      const url = `https://walmart-data.p.rapidapi.com/walmart-serp.php?url=https%3A%2F%2Fwww.walmart.com%2Fsearch%3Fq%3D${encodeURIComponent(product.replace(/ /g, '+'))}`;
      
      const headers = {
        "x-rapidapi-key": "098406a43cmsh1fd58e00b09fd8dp1d1387jsn5052a9ec7922",
        "x-rapidapi-host": "walmart-data.p.rapidapi.com"
      };
  
      const response = await fetch(url, {
        method: "GET",
        headers: headers,
      });
  
      if (!response.ok) {
        throw new Error(`Erro ao buscar lista de produtos. Código HTTP: ${response.status}`);
      }
  
      const data = await response.json();

      return data?.body?.products?.[0]?.image;
    } catch (error) {
      console.error("Erro ao buscar imagem do produto:", error);
      return undefined;
    }
  };
  


const ResultPage = () => {
    const location = useLocation();
    const navigate = useNavigate();

    // console.log(searchImage("samsung galaxy s23 fe"));

    const { state } = location as {state: {listResult: CardProps[]}};
    return (
        <Box>
            <Button color="white"  onClick={()=>navigate("/submission-form")}>Voltar</Button>
            <Flex wrap={"wrap"} gap={"2rem"}>
                {state?.listResult.map((item, index) => (
                    <CardList key={index} {...item} />
                ))}
            </Flex>
        </Box>
    );
};

export default ResultPage;