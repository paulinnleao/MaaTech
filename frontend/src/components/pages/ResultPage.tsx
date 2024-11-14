import React from "react";
import { CardList, CardProps } from "../item/CardList";

interface ResultPageProps {
    listResult: CardProps[];
}

const ResultPage: React.FC<ResultPageProps> = ({ listResult }) => {
    const testeImagem = {
        src: "https://wallpapers.com/images/high/goku-pictures-im28xdck0mbth703.webp",
        alt: "goku vermei",
        title: "GOKU VERMEI",
        description: "TESTANDO O GOKU VERMEI"
    } 
    return (
        <>
        <CardList {...testeImagem} />
            {/* {listResult.map((item, index) => (
                <CardList key={index} {...item} />
            ))} */}
        </>
    );
};

export default ResultPage;