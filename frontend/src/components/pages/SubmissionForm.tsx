import {
    SelectContent,
    SelectItem,
    SelectLabel,
    SelectRoot,
    SelectTrigger,
    SelectValueText,
} from "@/components/ui/select";
import { Formik, useFormik, useFormikContext } from "formik";

import selectOptions from "@/components/utils/selectOptions.json";
import { createListCollection } from "@chakra-ui/react";
// AIzaSyBNvPR9hxR2Z7R1Pe2rRoUR0V9DMplHwh8
//primaryUse;
//budget;
//preferredBrand;
//performanceLevel;
//numberOfUsers;
//spaceLimitations;
//usageFrequency;
//preferredDesign
//energyEfficiency
//needTechnicalSupport
//suggestAccessories
//deviceCompatibility
//durabilityLevel

interface SelectBodyProps {
    textValue: string;
    listOfOptions: any[];
    text: string;
    name: string;
  }
const SelectBody: React.FC<SelectBodyProps> = ({textValue, listOfOptions, text, name} ) => {
    const { setFieldValue } = useFormikContext();
    return <SelectRoot size={"lg"} collection={createListCollection({items: listOfOptions})}>
            <SelectLabel>{text}</SelectLabel>
                    <SelectTrigger>
                        <SelectValueText placeholder={textValue} />
                    </SelectTrigger>
                    <SelectContent>
                        {listOfOptions.map((item, index) => (
                        <SelectItem onClick={() => setFieldValue(name, item)} item={item} key={index}>
                            {item}
                        </SelectItem>
                        ))}
                    </SelectContent>
            </SelectRoot>
}

const SubmissionForm = () =>{
    const initialValues = {
        // Mandatory questions
        primaryUse: '',
        budget: 0,
        preferredBrand: '',
        numberOfUsers: 0,
        spaceLimitations: false,
        usageFrequency: '',
    
        // Optional questions
        preferredDesign: '',
        energyEfficiency: false,
        needTechnicalSupport: false,
        suggestAccessories: false,
        deviceCompatibility: '',
        durabilityLevel: '',
      };

    return <>
    <Formik
      initialValues={initialValues}
      onSubmit={(values) => {
        console.log(values);
      }}
    >
        {(formik) => (
             <form onSubmit={formik.handleSubmit}>
            <SelectBody 
                textValue={"Produto"} 
                listOfOptions={selectOptions.primaryUse}
                text={"Selecione o produto"}
                name="primaryUse" />
            <SelectBody
                textValue="Preferência de Marca"
                listOfOptions={selectOptions.preferredBrand}
                text="Selecione a Marca que deseja"
                name="preferredBrand" />
            <SelectBody
                textValue="Frequência de uso"
                listOfOptions={selectOptions.usageFrequency}
                text="Com qual frequência será o uso?"
                name="usageFrequency" />
            <SelectBody
                textValue="Preferência de Designer"
                listOfOptions={selectOptions.preferredDesign}
                text="Qual a sua preferência de design?"
                name="preferredDesign"/>
            <SelectBody
                textValue="Durabilidade"
                listOfOptions={selectOptions.durabilityLevel}
                text="Qual a durabildiade?"
                name="durabilityLevel" />

                <button type="submit">Enviar</button>
             </form>
        )}
    </Formik>
    </>
}

export default SubmissionForm;