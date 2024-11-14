import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './App.css';
import PaginaInicial from './components/pages/HomePage';
import SubmissionForm from "./components/pages/SubmissionForm";

const router = createBrowserRouter([
  {
    path: "/",
    element: <PaginaInicial />,
  },
  {
    path: "submission-form",
    element: <SubmissionForm />
  }
]);

function App() {
  
  return (
    <RouterProvider router = {router} />
  )
}

export default App
