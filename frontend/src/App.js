import {useCallback, useState} from "react";
import TransactionList from "./TransactionList";
import TransactionForm from "./TransactionForm"; 
import './index.css';
import Summary from "./Summary";
import LoginPage from "./LoginPage";


function App() {

    const [refresh, setRefresh] = useState(0);

    const [token, setToken] = useState(localStorage.getItem("token"));
   
    const logout = () => {
      localStorage.removeItem("token");
      setToken(null);
    }

    const handleTransactionAdded =useCallback(() => {
      setRefresh((prev) => prev + 1);
    },[]);
    // no token takes you to login page
  if(!token) return <LoginPage onLoginSuccess = {(newToken) => setToken(newToken)} />
// if token is valid - you see the app - if not - you are logged out and taken to login page
  return (
      <div className="min-h-screen bg-[#f5f5f5] p-8">
      <h1 className="text-3xl font-bold text-gray-800 mb-8">Finance Manager</h1>
      <button onClick={logout} className="bg-gray-800 text-white px-4 py-2 rounded-lg hover:bg-gray-600">Log out</button>
      <div className="max-w-4xl mx-auto flex flex-col gap-6">
      <Summary key = {refresh} />
      <TransactionForm onTransactionAdded={handleTransactionAdded} />
      <TransactionList key={refresh} />
      </div>
    </div>
  );


}
export default App;
