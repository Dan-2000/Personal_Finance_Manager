import {useCallback, useState} from "react";
import TransactionList from "./TransactionList";
import TransactionForm from "./TransactionForm"; 
import './index.css';
import Summary from "./Summary";
import LandingPage from "./LandingPage";

function App() {

    const [refresh, setRefresh] = useState(0);

    const [token, setToken] = useState(localStorage.getItem("token"));
    const [showLanding, setShowLanding] = useState(!token);

    const logout = () => {
      localStorage.removeItem("token");
      setToken(null);
      setShowLanding(true);
    }

    const handleLoginSuccess = (newToken) => {
      setToken(newToken);
      setShowLanding(false);
    };

    const handleTransactionAdded =useCallback(() => {
      setRefresh((prev) => prev + 1);
    },[]);
    // no token takes you to the landing page
    if (showLanding && !token) return (
      <LandingPage onLoginSuccess={handleLoginSuccess} />
    );
  return (
        <div className="min-h-screen bg-[#1a1a2e] p-8">
        <div className="max-w-4xl mx-auto">
            <div className="flex justify-between items-center mb-8">
                <h1 className="text-3xl font-bold text-white"> Finance Manager</h1>
                <button onClick={logout} className="bg-[#0f3460] text-[#a0aec0] hover:text-white px-4 py-2 rounded-xl border border-[#2d2d5e] hover:border-[#7c3aed] transition-colors duration-200">
                    Log out
                </button>
            </div>
            <div className="flex flex-col gap-6">
      <Summary refresh = {refresh} />
      <TransactionForm onTransactionAdded={handleTransactionAdded} />
      <TransactionList key={refresh} onRefresh={handleTransactionAdded} />
      </div>
    </div>
    </div>
  );


}
export default App;
