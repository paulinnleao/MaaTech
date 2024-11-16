import { Box, Button, DialogActionTrigger, DialogBody, DialogContent, DialogFooter, DialogHeader, DialogRoot, DialogTitle, DialogTrigger, Flex, Heading, Image, Portal, Text } from "@chakra-ui/react";
import { useRef } from "react";
import { CardProps } from "./CardList";

export interface ItemBodyProps{
    model: string;
    brand: string;
    avaragePrice: number;
    category: string;
    rating: string;
    reviewCount: string;
    weight: string;
    cardProps: CardProps;
}

const ModalProduct: React.FC<ItemBodyProps> = ({...item}) => {

    const ref = useRef<HTMLInputElement>(null)

    return  (
        <Portal>
            <DialogRoot 
                motionPreset="slide-in-left"
                placement="top" 
                role="alertdialog"
                initialFocusEl={() => ref.current}
                size="lg"
                    >
                <DialogTrigger asChild>
                    <Button variant="outline" size="sm">
                    Ver mais
                    </Button>            
                </DialogTrigger>
                    <DialogContent >
                        <DialogHeader margin={"auto"}>
                            <DialogTitle>{item.cardProps.title}</DialogTitle>
                        </DialogHeader>
                        <DialogBody >
                            <Image src={item.cardProps.src} alt={item.cardProps.alt}/>
                            <Box p="1rem 0" textAlign="left">
                                <Heading>Description</Heading>
                                <Text>{item.cardProps.description}</Text>
                            </Box>
                            <Flex gap="2rem" wrap="wrap">
                                <Box>
                                    <Heading>Model</Heading>
                                    <Text>{item.model}</Text>
                                </Box>
                                <Box>
                                    <Heading>Brand</Heading>
                                    <Text>{item.brand}</Text>
                                </Box>
                                <Box>
                                    <Heading>Category</Heading>
                                    <Text>{item.category}</Text>
                                </Box>
                                <Box>
                                    <Heading>Weight</Heading>
                                    <Text>{item.weight}</Text>
                                </Box>
                            </Flex>
                            <Box p="1rem 0">
                                <Heading>Avarage Price</Heading>
                                <Text color={"green"}>R$ {item.avaragePrice}</Text>
                            </Box>
                        </DialogBody>
                        <DialogFooter>
                            <DialogActionTrigger asChild>
                                <Button variant="outline">Cancel</Button>
                            </DialogActionTrigger>
                            <Button colorPalette="red">Delete</Button>
                        </DialogFooter>
                    </DialogContent>
            </DialogRoot>
    </Portal>
    )
}

export default ModalProduct;