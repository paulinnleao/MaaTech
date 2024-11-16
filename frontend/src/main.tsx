import { Provider } from "@/components/ui/provider"
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { createStore, action, StoreProvider } from "easy-peasy"

const store = createStore({
  token: "",
  inputToken: action((state: any, payload: string)=>{
    state.token = payload
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
