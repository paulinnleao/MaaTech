import { useStoreState } from "easy-peasy";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useEndpoints } from "../utils/useEndpoints";
import { CardList } from "../item/CardList";
import { ItemBodyProps } from "../item/ModalProduct";
import { imageNotFount } from "../utils/util";

const ListProductsUserPage = () => {
  const logado = useStoreState((state: any) => state.token);
  const userAccountDetails = useStoreState((state: any) => state.userAccountDetails);
  const navigate = useNavigate();
  const { endFindUserList, useSearchImage } = useEndpoints();

  const [listUser, setListUser] = useState<ItemBodyProps[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      if (!logado) {
        navigate("/user-not-logged-in");
        return;
      }

      try {
        const result = await endFindUserList(userAccountDetails.idUser, logado);
        if (result) {
          const updatedList = await Promise.all(
            result.map(async (item: ItemBodyProps) => {
              const imageSrc = await useSearchImage(item.name);

              return { ...item, src: imageSrc ?? imageNotFount };
            })
          );
          setListUser(updatedList);
        }
      } catch (error) {
        console.error("Erro ao buscar usuários:", error);
      }
    };

    fetchData();
  }, [logado, userAccountDetails, navigate, endFindUserList, useSearchImage]);

  return (
    <>
      {listUser.map((item, index) => (
        <CardList key={index} {...item} />
      ))}
    </>
  );
};

export default ListProductsUserPage;
