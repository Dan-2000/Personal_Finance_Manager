import TransactionList from "./TransactionList";
import TransactionForm from "./TransactionForm"; 
import Summary from "./Summary";
function App() {
  return (
    <div>
      <h1>Welcome to the Finance Manager!</h1>
      <Summary />
      <TransactionForm onTransactionAdded={() =>window.location.reload()} />
      <TransactionList />
    </div>
  );
}
export default App;
