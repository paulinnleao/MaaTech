import { Card, CardBody, CardFooter, Heading, Image, Text } from "@chakra-ui/react";
import ModalProduct, { ItemBodyProps } from "./ModalProduct";
import { useEffect, useState } from "react";
import { imageNotFount } from "../utils/util";

export const CardList: React.FC<ItemBodyProps> = ({ ...item }) => {

    const [resolvedSrc, setResolvedSrc] = useState<string>("");

    useEffect(() => {
        const resolveImageSrc = async () => {
            if (item.src instanceof Promise) {
                const src = await item.src;
                setResolvedSrc(src || imageNotFount);
            } else {
                setResolvedSrc(item.src);
            }
        };
        resolveImageSrc();
    }, [item.src]);


    return (
        <Card.Root maxW="sm" overflow="hidden">
            <Image
                src={resolvedSrc}
                alt={item.alt}
            />
            <CardBody>
                <Heading size="md">{item.name}</Heading>
                <Text>{item.description}</Text>
            </CardBody>
            <CardFooter>
                <ModalProduct {...item}/>
            </CardFooter>
        </Card.Root>
    );
};