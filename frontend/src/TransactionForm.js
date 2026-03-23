import {useState} from "react";

function TransactionForm({onTransactionAdded}) {
const [formData, setFormData] = useState({
    date : "",
    description : "",
    amount : "",
    type : ""
})
const handleSubmit = async (e) => {
    e.preventDefault();

const response = await fetch("https://organic-broccoli-59prrvq9pvq3v5xq-8080.app.github.dev/transactions", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(formData) });

    if (response.ok) {
        onTransactionAdded();
        setFormData({date : "", description : "", amount : "", type : ""});
    }
};
return (
    <div>
        <h3> Add Transaction </h3>
        <form onSubmit ={handleSubmit}>
            <input
                type="text"
                placeholder="Date (YYYY-MM-DD)"
                value={formData.date}
                onChange={(e)=> setFormData({ ...formData, date: e.target.value})}/>

                <input
                type="text"
                placeholder="Description"
                value={formData.description}
                onChange={(e)=> setFormData({ ...formData, description: e.target.value})}/>

                <input
                type="number"
                placeholder="Amount"
                value={formData.amount}
                onChange={(e) => setFormData({ ...formData, amount: e.target.value})}/>

                <select 
                value ={formData.type}
                onChange={(e) => setFormData({ ...formData, type: e.target.value})}>
                    <option value="">Select type</option>
                    <option value="INCOME">Income</option>
                    <option value="EXPENSE">Expense</option>
                </select>
                <button type="submit">Add Transaction</button>
        </form>
    </div>
);
}
export default TransactionForm;