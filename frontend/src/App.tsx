import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './App.css';
import PaginaInicial from './components/pages/HomePage';
import SubmissionForm from "./components/pages/SubmissionForm";
import ResultPage from "./components/pages/ResultPage";

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
    <RouterProvider router = {router} />
  )
}

export default App
