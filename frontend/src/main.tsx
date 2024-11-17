import { Provider } from "@/components/ui/provider"
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { createStore, action, StoreProvider } from "easy-peasy"


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
      <Provider>
        <App />
      </Provider>
    </StoreProvider>
  </StrictMode>,
)
