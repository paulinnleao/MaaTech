import { Box, ChakraProvider, createSystem, defineConfig } from "@chakra-ui/react";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import HeaderPage from "./components/item/HeaderPage";
import PaginaInicial from './components/pages/HomePage';
import ListProductsUserPage from "./components/pages/ListProductsUserPage";
import ResultPage from "./components/pages/ResultPage";
import SubmissionForm from "./components/pages/SubmissionForm";
import UserNotLoggedIn from "./components/pages/UserNotLoggedIn";
import { ToastContainer } from "react-toastify";
import { Provider } from "./components/ui/provider";

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
  },
  {
    path: "user-list",
    element: <ListProductsUserPage />
  },
  {
    path:"user-not-logged-in",
    element: <UserNotLoggedIn />
  }
]);

function App() {
  

  return (
    <Provider>
      <Box  backgroundColor={"#F0F8FF"} w="100%" h="100%">
        <HeaderPage />
        <RouterProvider router = {router} />
        <ToastContainer />
      </Box>
    </Provider>
  )
}

export default App
