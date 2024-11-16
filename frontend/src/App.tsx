import { Box } from "@chakra-ui/react";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './App.css';
import HeaderPage from "./components/item/HeaderPage";
import PaginaInicial from './components/pages/HomePage';
import ResultPage from "./components/pages/ResultPage";
import SubmissionForm from "./components/pages/SubmissionForm";

const router = createBrowserRouter([
  {
    path: "/",
    element: <PaginaInicial />,
  },
  {
    path: "submission-form",
    element: <SubmissionForm />
  },
  {
    path: "result-form",
    element: <ResultPage />
  }
]);

function App() {
  return (
    <Box>
      <HeaderPage />
      <RouterProvider router = {router} />
    </Box>
  )
}

export default App
