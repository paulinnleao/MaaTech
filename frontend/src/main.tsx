import { action, createStore, StoreProvider } from "easy-peasy";
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import 'react-toastify/dist/ReactToastify.css';
import App from './App.tsx';


const store = createStore({
  userAccountDetails: {
    idUser: "",
    name: "",
    email: "",
    role: ""
  },
  token: "",
  inputToken: action((state: any, payload: string)=>{
    state.token = payload
  }),
  inputUserAccountDetails: action((state: any, payload: {idUser: string, name: string, email: string}) =>{
    state.userAccountDetails = {...payload}
  })
});

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <StoreProvider store={store}>
        <App />
    </StoreProvider>
  </StrictMode>,
)
