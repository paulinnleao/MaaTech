import { Card, CardBody, Heading, CardFooter, Button, Image, Text, DialogRoot, DialogTrigger } from "@chakra-ui/react";
import ModalProduct from "./ModalProduct";

export interface CardProps {
    src: string;
    alt: string;
    title: string;
    description: string;
}

export const CardList: React.FC<CardProps> = ({ src, alt, title, description }) => {



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
                <DialogRoot role="alertdialog">
                    <DialogTrigger asChild>
                        <Button variant="outline" size="sm">
                        Open Dialog
                        </Button>
                        <ModalProduct />
                    </DialogTrigger>
                </DialogRoot>
            </CardFooter>
        </Card.Root>
    );
};