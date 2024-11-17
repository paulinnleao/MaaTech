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
import { ToastContainer } from "react-toastify";
import UserNotLoggedIn from "./components/pages/UserNotLoggedIn";
import ListProductsUserPage from "./components/pages/ListProductsUserPage";

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
    <Box>
      <HeaderPage />
      <RouterProvider router = {router} />
      <ToastContainer />
    </Box>
  )
}

export default App
