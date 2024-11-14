import React from "react";
import { CardList, CardProps } from "../item/CardList";

interface ListProductsUserPageProps {
    listResult: CardProps[];
}

const ListProductsUserPage: React.FC<ListProductsUserPageProps> = ({listResult}) => {
    return (<>
        {listResult.map((item, index) => (
                <CardList key={index} {...item} />
            ))}
    </>);

}

export default ListProductsUserPage;