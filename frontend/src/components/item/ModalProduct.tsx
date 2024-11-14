import { Button, DialogContent, DialogHeader, DialogTitle, DialogBody, DialogFooter, DialogActionTrigger, DialogCloseTrigger, DataListItem } from "@chakra-ui/react";
import { CardProps } from "./CardList";

interface ModalProductProps{
    descricao: string;
    detalhes: {
        dimensoes: string;
        materia: string;
    };
    avaliacoes: string;
    especificacoes: {
        material: string;
        algumaCoisaTecnica: string;
    };
    justificativa: string;
    cardProps: CardProps;
}

const ModalProduct: React.FC<ModalProductProps> = ({...item}) => {

    return <DialogContent>
                <DialogHeader>
                    <DialogTitle>{item.cardProps.title}</DialogTitle>
                </DialogHeader>
                <DialogBody pb="8">
                    <DataListItem />
                </DialogBody>
                <DialogFooter>
                    <DialogActionTrigger asChild>
                        <Button variant="outline">Cancel</Button>
                    </DialogActionTrigger>
                    <Button colorPalette="red">Delete</Button>
                </DialogFooter>
                <DialogCloseTrigger />
        </DialogContent>
}

export default ModalProduct;