import {
    SelectContent,
    SelectItem,
    SelectLabel,
    SelectRoot,
    SelectTrigger,
    SelectValueText,
} from "@/components/ui/select";
import { Slider } from "@/components/ui/slider"
import { Field } from "@/components/ui/field"
import { Formik, useFormikContext } from "formik";

import selectOptions from "@/components/utils/selectOptions.json";
import { createListCollection, Flex, Input } from "@chakra-ui/react";
import { Checkbox } from "../ui/checkbox";
import { useNavigate } from "react-router-dom";
import { useEndpoints } from "../utils/useEndpoints";

export interface SubmissionFormProps {
    primaryUse: string;
    budget: number;
    preferredBrand: string;
    numberOfUsers: number;
    spaceLimitations: boolean;
    usageFrequency: string;
    preferredDesign: string;
    energyEfficiency: boolean;
    needTechnicalSupport: boolean;
    suggestAccessories: boolean;
    deviceCompatibility: string;
    durabilityLevel: string;
}

interface SelectBodyProps {
    textValue: string;
    listOfOptions: any[];
    text: string;
    name: string;
  }

const SelectBody: React.FC<SelectBodyProps> = ({textValue, listOfOptions, text, name} ) => {
    const { setFieldValue } = useFormikContext();
    return <SelectRoot size="sm" collection={createListCollection({items: listOfOptions})}>
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
    const navigate = useNavigate();
    const {useSearchForm} = useEndpoints();
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
      onSubmit={async (values: SubmissionFormProps) => {       
        try {
            const listaa = ["Samsung Galaxy Book Go", "Samsung Galaxy Book2", "Samsung Galaxy Chromebook Go", "Samsung Chromebook 4", "Samsung Chromebook Plus V2", "Samsung Notebook 9 Always", "Samsung Notebook Flash\n* Samsung XE513Q2B-K01BR", "Samsung NP300E5X", "Samsung NP530U3C", "Samsung NP305E5A", "Samsung NP300V5A", "Samsung RV411", "Samsung NP-R540", "Samsung 300E5A-A02BR", "Samsung NP300E5X-XD1BR", "Samsung NP-RC510", "Samsung ATIV Book 6", "Samsung Series 5 Ultra", "Samsung Series 9"]
            navigate("/result-form", { state: { listResult: listaa} });
            // const result = await useSearchForm(values);
            
            // if (result && result.length > 0) {
            //     navigate("/result-page", { state: { listaResult: result } });
            // } else {
            //     console.warn("Nenhum resultado encontrado");
            // }
        } catch (error) {
            console.error("Erro durante a submissão do formulário", error);
        }
    }}
    >
        {(formik) => (
             <form onSubmit={formik.handleSubmit}>
                <Flex gap="1rem" wrap="wrap" marginBottom="1rem" direction="column">
                    <SelectBody 
                        textValue={"Produto"} 
                        listOfOptions={selectOptions.product}
                        text={"Selecione o produto"}
                        name="primaryUse" />
                    <Field label="Valor R$">
                        <Input 
                        onChange={formik.handleChange} onBlur={formik.handleBlur} name="budget" placeholder="Ex: 1.000,00" />
                        </Field>
                    <SelectBody
                        textValue="Preferência de Marca"
                        listOfOptions={selectOptions.preferredBrand}
                        text="Selecione a Marca que deseja"
                        name="preferredBrand" />
                        <Field label="Quantidade de usuários">
                            <Input 
                            onChange={formik.handleChange} onBlur={formik.handleBlur} name="numberOfUsers" placeholder="Ex: 3"/>
                        </Field>
                        <Field label="Espaço Limitado" display="flex" flexDir="row" gap="1rem">
                            <Checkbox onChange={()=>formik.setFieldValue("spaceLimitations",!formik.values.spaceLimitations)} name="spaceLimitations" />
                        </Field>
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
                        <Field label="Economia de Energia" display="flex" flexDir="row" gap="1rem">
                            <Checkbox onChange={()=>formik.setFieldValue("energyEfficiency",!formik.values.energyEfficiency)}  name="energyEfficiency" />
                        </Field>
                        <Field label="Suporte Técnico" display="flex" flexDir="row" gap="1rem">
                            <Checkbox onChange={()=>formik.setFieldValue("needTechnicalSupport",!formik.values.needTechnicalSupport)}  name="needTechnicalSupport" />
                        </Field>
                        <Field label="Compatibilidade Com Outros Aparelhos" display="flex" flexDir="row" gap="1rem">
                            <Checkbox onChange={()=>formik.setFieldValue("deviceCompatibility",!formik.values.deviceCompatibility)} name="deviceCompatibility" />
                        </Field>
                    <SelectBody
                        textValue="Durabilidade"
                        listOfOptions={selectOptions.durabilityLevel}
                        text="Qual a durabildiade?"
                        name="durabilityLevel" />
                </Flex>
                <button type="submit">Enviar</button>
             </form>
        )}
    </Formik>
    </>
}

export default SubmissionForm;