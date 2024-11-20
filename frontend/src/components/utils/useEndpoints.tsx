import { useStoreActions } from "easy-peasy";
import { Bounce, toast } from "react-toastify";
import { ItemBodyProps } from "../item/ModalProduct";
import { imageNotFount } from "./util";
import { SubmissionFormProps } from "../pages/SubmissionForm";

export const useEndpoints = () => {
  const inputToken = useStoreActions<any>((actions) => actions.inputToken);
  const inputUserAccountDetails = useStoreActions<any>((actions) => actions.inputUserAccountDetails);

  const urlDefault = 'http://localhost:8080';
  const notifyError = (text: string) => toast.error(text,  {
    position: "bottom-center",
    autoClose: 5000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
    draggable: true,
    progress: undefined,
    theme: "dark",
    transition: Bounce,
    });
  const notifySuccess = (text: string) => toast.success(text, {
      position: "bottom-center",
      autoClose: 5000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
      theme: "dark",
      transition: Bounce,
      });
  const endLogin = async (values: { email: string; password: string }) => {
    try {
      const response = await fetch(`${urlDefault}/auth/login`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(values),
      });

      if (!response.ok) {
        throw new Error("Erro ao fazer login");
      }

      const data = await response.json();
      const token = data.token;
      inputToken(token);

      const findUserByEmail = async (email: string, token: string) => {
        try{
          console.log("email " + email + "\n token " + token);
          const res = await fetch(`${urlDefault}/users/email/${email}`,
            {
              method: "GET",
              headers: {
                "Authorization" : `Bearer ${token}`
              }
            }
          )

          if(!res.ok){
            throw new Error("Erro ao buscar usuário pelo email");
          }

          const data = await res.json();

          inputUserAccountDetails(data);
        }catch (error) {
          toast(`${error}`, {
            position: "bottom-center",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "dark",
            transition: Bounce,
            });
        }
      }
      
    findUserByEmail(values.email, token);
    } catch (error) {
      notifyError(`${error}`);
    }
    
  };

const endRegister = async (values: { name: string; email: string; password: string }) => {
    try {
      const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(values),
      });

      if (!response.ok) {
        throw new Error("Erro ao tentar realizar cadastro");
      }

      return true;
    } catch (error) {
      notifyError(`${error}`);
    }
  };

  const endFindUserList = async (idUser: string, token: string): Promise<ItemBodyProps[] | undefined> => {
    try {
      const response = await fetch(`http://localhost:8080/list-of-items/${idUser}`, {
        method: "GET",
        headers: {
          "Authorization": `Bearer ${token}`,
        },
      });
  
      if (!response.ok) {
        throw new Error("Erro ao buscar lista do usuário");
      }
  
      const data = await response.json();
  
      if (!Array.isArray(data)) {
        throw new Error("A resposta não é uma lista de itens");
      }
  
      return data as ItemBodyProps[];
    } catch (error) {
      notifyError(`${error}`);
      return undefined;
    }
  };
  

  
  const useSearchImage = async (product: string): Promise<string | undefined> => {
    try {
      const url = `https://walmart-data.p.rapidapi.com/walmart-serp.php?url=https%3A%2F%2Fwww.walmart.com%2Fsearch%3Fq%3D${encodeURIComponent(product.replace(/ /g, '+'))}`;
  
      const headers = {
        "x-rapidapi-key": "098406a43cmsh1fd58e00b09fd8dp1d1387jsn5052a9ec7922",
        "x-rapidapi-host": "walmart-data.p.rapidapi.com",
      };
  
      // const response = await fetch(url, {
      //   method: "GET",
      //   headers,
      // });
  
      // if (!response.ok) {
      //   console.warn(`API retornou status: ${response.status}`);
      //   return undefined;
      // }
  
      // const data = await response.json();

      // return data?.body?.products?.[0]?.image;
      return "";
    } catch (error) {
      console.error("Erro ao buscar imagem do produto:", error);
      return undefined;
    }
  };
  

  const useAssembleTheItemBody = async (product: string) : Promise<ItemBodyProps | undefined> => {
    const apiKey = "AIzaSyC9IMBVBNdpT4vCSAtuHJr946zkEWBf2rw";
    const endpoint = `https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=${apiKey}`;
    
    const requestBody = {
      contents: [
        {
          parts: [
            {
              text: `Me forneça os dados do produto ${product}. Preciso que me forneça um json com os seguintes dados: model, brand, averagePrice, category, rating, reviewCount, weight, cardProps, alt (para colocar na imagem), description (eu preciso que você descreva com detalhes técnicos, por exemplo, se for notebook, qual processador etc).`,
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
        const imageSrc = await useSearchImage(product);

        const itemBody: ItemBodyProps = {
          src: imageSrc || imageNotFount,
          alt: data?.alt ?? "",
          name: product,
          description: data?.description ?? "",
          model: data?.model ?? "",
          brand: data?.brand ?? "",
          averagePrice: data?.averagePrice ?? 0, // Verifique se o nome está correto
          category: data?.category ?? "",
          rating: data?.rating ?? "",
          reviewCount: data?.reviewCount ?? "",
          weight: data?.weight ?? ""
        };
          
        return itemBody;
        console.log(itemBody)
      } catch (error) {
        console.error("Error fetching data:", error);
      }
}

  const useSearchForm = async (values: SubmissionFormProps): Promise<string[] | undefined> => {
    try {
        const response = await fetch(`${urlDefault}/search-form`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(values),
        });

        if (!response.ok) {
            throw new Error("Erro ao buscar lista de produtos");
        }

        const data = await response.json();
        const stringResult = data?.candidates[0]?.content?.parts?.text as string;

        if (stringResult) {
            return stringResult.split('\n').map(produto => produto.replace(/^\d+\./, '').trim());
        }

        return undefined;
    } catch (error) {
        console.error("Erro ao buscar lista de produtos ", error);
        return undefined;
    }
  };

  return { 
    endLogin, 
    endRegister, 
    endFindUserList, 
    useSearchImage, 
    useAssembleTheItemBody, 
    useSearchForm,
    notifySuccess,
    notifyError };

};