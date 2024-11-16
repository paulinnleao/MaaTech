import { Card, CardBody, CardFooter, Heading, Image, Text } from "@chakra-ui/react";
import ModalProduct, { ItemBodyProps } from "./ModalProduct";
import { useEffect, useState } from "react";

export interface CardProps {
    src: Promise <string | undefined> | string;
    alt: string;
    title: string;
    description: string;
}

export const CardList: React.FC<ItemBodyProps> = ({ ...item }) => {

    const [resolvedSrc, setResolvedSrc] = useState<string>("");

    useEffect(() => {
        const resolveImageSrc = async () => {
            if (item.cardProps.src instanceof Promise) {
                const src = await item.cardProps.src;
                setResolvedSrc(src || "");
            } else {
                setResolvedSrc(item.cardProps.src);
            }
        };
        resolveImageSrc();
    }, [item.cardProps.src]);


    return (
        <Card.Root maxW="sm" overflow="hidden">
            <Image
                src={resolvedSrc}
                alt={item.cardProps.alt}
            />
            <CardBody>
                <Heading size="md">{item.cardProps.title}</Heading>
                <Text>{item.cardProps.description}</Text>
            </CardBody>
            <CardFooter>
                <ModalProduct {...item} />
            </CardFooter>
        </Card.Root>
    );
};