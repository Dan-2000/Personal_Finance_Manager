import {useCallback, useState} from "react";
import TransactionList from "./TransactionList";
import TransactionForm from "./TransactionForm"; 
import './index.css';
import Summary from "./Summary";
function App() {

    const [started, setStarted] = useState(false);
    const [refresh, setRefresh] = useState(0);
    const handleTransactionAdded =useCallback(() => {
      setRefresh((prev) => prev + 1);
    },[]);
  if(!started)
  return (

    <div className="min-h-screen bg-[#f5f5f5] flex items-center justify-center">
      <h1 className="text-5xl font-bold text-gray-800 cursor-pointer hover:text-gray-500 transition-colors duration-300"
       onClick={() =>setStarted(true)} >Welcome to the Finance Manager!</h1>
    </div>
  );

return(
  <div className="min-h-screen bg-[#f5f5f5] p-8">
      <h1 className="text-3xl font-bold text-gray-800 mb-8">Finance Manager</h1>
      <div className="max-w-4xl mx-auto flex flex-col gap-6">
      <Summary key = {setRefresh} />
      <TransactionForm onTransactionAdded={handleTransactionAdded} />
      <TransactionList key={refresh} />
      </div>
    </div>

)
}
export default App;
