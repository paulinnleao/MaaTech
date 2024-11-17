import { Box, Button, DialogActionTrigger, DialogBody, DialogContent, DialogFooter, DialogHeader, DialogRoot, DialogTitle, DialogTrigger, Flex, Heading, Image, Portal, Text } from "@chakra-ui/react";
import { useEffect, useRef, useState } from "react";
import { imageNotFount } from "../utils/util";

export interface ItemBodyProps{
    model: string;
    brand: string;
    averagePrice: number;
    category: string;
    rating: string;
    reviewCount: string;
    weight: string;
    src: Promise <string | undefined> | string;
    alt: string;
    name: string;
    description: string;
}

const ModalProduct: React.FC<ItemBodyProps> = ({...item}) => {

    const ref = useRef<HTMLInputElement>(null)

    
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
                            <DialogTitle>{item.name}</DialogTitle>
                        </DialogHeader>
                        <DialogBody >
                            <Image src={resolvedSrc} alt={item.alt}/>
                            <Box p="1rem 0" textAlign="left">
                                <Heading>Description</Heading>
                                <Text>{item.description}</Text>
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
                                <Heading>Average Price</Heading>
                                <Text color={"green"}>R$ {item.averagePrice}</Text>
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