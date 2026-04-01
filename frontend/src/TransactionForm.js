import {useState} from "react";

function TransactionForm({onTransactionAdded}) {
const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";
const [formData, setFormData] = useState({
    date : "",
    description : "",
    amount : "",
    type : ""
})
const token = localStorage.getItem("token");
const handleSubmit = async (e) => {
    e.preventDefault();

const response = await fetch(`${API_URL}/transactions`, {
    method: "POST",
    headers: {"Content-Type": "application/json", "Authorization" : `Bearer ${token}`},
    body: JSON.stringify(formData) });

    if (response.ok) {
        onTransactionAdded();
        setFormData({date : "", description : "", amount : "", type : ""});
    }
};
return (
     <div className="bg-[#16213e] rounded-2xl p-6 border border-[#2d2d5e] shadow-xl">
        <h2 className="text-xl font-bold text-white mb-6">Add Transaction</h2>
        <form onSubmit ={handleSubmit} className="flex flex-col gap-4">
            <input
                type="date"
                placeholder="Date (YYYY-MM-DD)"
                value={formData.date}
                onChange={(e)=> setFormData({ ...formData, date: e.target.value})} className="bg-[#0f3460] text-white rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
            />

                <input
                type="text"
                placeholder="Description"
                value={formData.description}
                onChange={(e)=> setFormData({ ...formData, description: e.target.value})} className="bg-[#0f3460] text-white placeholder-[#a0aec0] rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
                />

                <input
                type="number"
                placeholder="Amount"
                value={formData.amount}
                onChange={(e) => setFormData({ ...formData, amount: e.target.value})} className="bg-[#0f3460] text-white placeholder-[#a0aec0] rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
                />
                <select 
                value ={formData.type}
                onChange={(e) => setFormData({ ...formData, type: e.target.value})} className="bg-[#0f3460] text-white rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]">
                    <option value="">Select type</option>
                    <option value="INCOME">Income</option>
                    <option value="EXPENSE">Expense</option>
                </select>
                <button type="submit" className="bg-[#7c3aed] hover:bg-[#6d28d9] text-white font-bold py-3 rounded-xl transition-colors duration-200">Add Transaction</button>
        </form>
    </div>
);
}
export default TransactionForm;