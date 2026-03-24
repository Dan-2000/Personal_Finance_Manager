import {useState} from "react";

function TransactionForm({onTransactionAdded}) {
const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";
const [formData, setFormData] = useState({
    date : "",
    description : "",
    amount : "",
    type : ""
})
const handleSubmit = async (e) => {
    e.preventDefault();

const response = await fetch(`${API_URL}/transactions`, {
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
                type="date"
                placeholder="Date (YYYY-MM-DD)"
                value={formData.date}
                onChange={(e)=> setFormData({ ...formData, date: e.target.value})} className="border border-gray-200 rounded-lg p-3 text-gray-800 bg-[#f5f5f5] focus:outline-none focus:border-gray-400"
            />

                <input
                type="text"
                placeholder="Description"
                value={formData.description}
                onChange={(e)=> setFormData({ ...formData, description: e.target.value})} className="border border-gray-200 rounded-lg p-3 text-gray-800 bg-[#f5f5f5] focus:outline-none focus:border-gray-400"
                />

                <input
                type="number"
                placeholder="Amount"
                value={formData.amount}
                onChange={(e) => setFormData({ ...formData, amount: e.target.value})} className="border border-gray-200 rounded-lg p-3 text-gray-800 bg-[#f5f5f5] focus:outline-none focus:border-gray-400"
                />

                <select 
                value ={formData.type}
                onChange={(e) => setFormData({ ...formData, type: e.target.value})} className="border border-gray-200 rounded-lg p-3 text-gray-800 bg-[#f5f5f5] focus:outline-none focus:border-gray-400">
                    <option value="">Select type</option>
                    <option value="INCOME">Income</option>
                    <option value="EXPENSE">Expense</option>
                </select>
                <button type="submit" className="bg-gray-800 text-white rounded-lg p-3 font-semibold hover:bg-gray-600 transition-colors duration-200">Add Transaction</button>
        </form>
    </div>
);
}
export default TransactionForm;