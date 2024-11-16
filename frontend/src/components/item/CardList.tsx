import { Card, CardBody, CardFooter, Heading, Image, Text } from "@chakra-ui/react";
import ModalProduct from "./ModalProduct";

export interface CardProps {
    src: string;
    alt: string;
    title: string;
    description: string;
}

export const CardList: React.FC<CardProps> = ({ src, alt, title, description }) => {
const item = {
        model: "string",
        brand: "string",
        avaragePrice: 0,
        category: "string",
        rating: "string",
        reviewCount: "string",
        weight: "string",
        cardProps: {
            src,
            alt,
            title, 
            description
        }
    }
    return (
        <Card.Root maxW="sm" overflow="hidden">
            <Image
                src={src}
                alt={alt}
            />
            <CardBody>
                <Heading size="md">{title}</Heading>
                <Text>{description}</Text>
            </CardBody>
            <CardFooter>
                <ModalProduct {...item} />
            </CardFooter>
        </Card.Root>
    );
};