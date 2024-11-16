import { Box, Button, Flex } from "@chakra-ui/react";
import { CardList, CardProps } from "../item/CardList";
import { useLocation, useNavigate } from "react-router-dom";
import { ItemBodyProps } from "../item/ModalProduct";
import { useEffect, useState } from "react";
// AIzaSyBNvPR9hxR2Z7R1Pe2rRoUR0V9DMplHwh8


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
  
const assembleTheItemBody = async (product: string) : Promise<ItemBodyProps | undefined> => {
    const apiKey = "AIzaSyC9IMBVBNdpT4vCSAtuHJr946zkEWBf2rw";
    const endpoint = `https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=${apiKey}`;
    
    const requestBody = {
      contents: [
        {
          parts: [
            {
              text: `Me forneça os dados do produto ${product}. Preciso que me forneça um json com os seguintes dados: model, brand, avaragePrice, category, rating, reviewCount, weight, cardProps, alt (para colocar na imagem), description.`,
            },
          ],
        },
      ],
    };
    
    try {
        const response = await fetch(endpoint, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(requestBody),
        });
    
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        const itemBody = {
            model: data?.model,
            brand: data?.brand,
            avaragePrice: data?.avaragePrice,
            category: data?.category,
            rating: data?.rating,
            reviewCount: data?.reviewCount,
            weight: data?.weight,
            cardProps: {
              src: await searchImage(product) ?? "",
              alt: data?.alt,
              title: product,
              description: data?.description
            }
          } as ItemBodyProps;
          
        return itemBody;
      } catch (error) {
        console.error("Error fetching data:", error);
      }

}

const ResultPage = () => {
    const location = useLocation();
    const navigate = useNavigate();

    const { state } = location as {state: {listResult: string[]}};
    const [listProducts, setListProducts] = useState<ItemBodyProps[]>([]);

    useEffect(() => {
        const fetchProducts = async () => {
            const resolvedProducts = await Promise.all(
                state.listResult.map((product) => assembleTheItemBody(product))
            );

            setListProducts(resolvedProducts.filter(Boolean) as ItemBodyProps[]);
        };

        fetchProducts();
    }, [state.listResult]);

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