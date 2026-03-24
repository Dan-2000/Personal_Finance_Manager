import TransactionList from "./TransactionList";
import TransactionForm from "./TransactionForm"; 
import './index.css';
import Summary from "./Summary";
function App() {
  return (
    <div className="min-h-screen bg-[#1a1a2e] text-white p-8">
      <h1 className="text-3xl font-bold text-purple-400 mb-8">Welcome to the Finance Manager!</h1>
      <Summary />
      <TransactionForm onTransactionAdded={() =>window.location.reload()} />
      <TransactionList />
    </div>
  );
}
export default App;
