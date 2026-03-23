import TransactionList from "./TransactionList";
import TransactionForm from "./TransactionForm"; 
function App() {
  return (
    <div>
      <h1>Welcome to the Finance Manager!</h1>
      <TransactionForm onTransactionAdded={() =>window.location.reload()} />
      <TransactionList />
    </div>
  );
}
export default App;
