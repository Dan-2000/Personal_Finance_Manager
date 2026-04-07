import { useState } from "react";

function EditModal({ transaction, onClose, onSave }) {
 
    const [formData, setFormData] = useState({
    date: transaction.date,
    description: transaction.description,
    amount: transaction.amount,
    type: transaction.type
  });

const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";
const token = localStorage.getItem("token");

  const handleSave = async () => {
//debugging 
    console.log("Transaction:", transaction);
    console.log("ID:", transaction.ID);

   const response = await fetch(`${API_URL}/transactions/${transaction.ID}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      },
      body: JSON.stringify(formData)
    });

    if (response.ok) {
      onSave();
      onClose();
    }
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-60 flex items-center justify-center z-50">
        <div className="bg-[#16213e] rounded-2xl p-8 border border-[#2d2d5e] w-full max-w-md shadow-2xl">
            <h2 className="text-xl font-bold text-white mb-6">Edit Transaction</h2>
            <div className="flex flex-col gap-4">
                <input
                    type="date"
                    value={formData.date}
                    onChange={(e) => setFormData({...formData, date: e.target.value})}
                    className="bg-[#0f3460] text-white rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
                />
                <input
                    type="text"
                    placeholder="Description"
                    value={formData.description}
                    onChange={(e) => setFormData({...formData, description: e.target.value})}
                    className="bg-[#0f3460] text-white placeholder-[#a0aec0] rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
                />
                <input
                    type="number"
                    value={formData.amount}
                    onChange={(e) => setFormData({...formData, amount: parseFloat(e.target.value)})}
                    className="bg-[#0f3460] text-white rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
                />
                <select
                    value={formData.type}
                    onChange={(e) => setFormData({...formData, type: e.target.value})}
                    className="bg-[#0f3460] text-white rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
                >
                    <option value="INCOME">Income</option>
                    <option value="EXPENSE">Expense</option>
                </select>
                <div className="flex gap-3 mt-2">
                    <button onClick={handleSave}
                        className="flex-1 bg-[#7c3aed] hover:bg-[#6d28d9] text-white font-bold py-3 rounded-xl transition-colors duration-200">
                        Save
                    </button>
                    <button onClick={onClose}
                        className="flex-1 bg-[#0f3460] hover:bg-[#1a1a2e] text-[#a0aec0] hover:text-white font-bold py-3 rounded-xl border border-[#2d2d5e] transition-colors duration-200">
                        Cancel
                    </button>
                </div>
            </div>
        </div>
    </div>
);
}

export default EditModal;