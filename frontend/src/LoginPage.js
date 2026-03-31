import {useState } from "react";

function LoginPage({onLoginSuccess}) {
    const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";

    const [isRegistering, setIsRegistering] = useState(false);
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleRegister = async (e) => {
        e.preventDefault();

        const response = await fetch(`${API_URL}/register`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            //role is default to USER - if an ADMIN role is needed -it will be changed by the database admin
            body: JSON.stringify({email, password, role: "USER"})
        });

        if (response.ok) {
            setIsRegistering(false);
            setError("Registration successful! Please log in.");
        }
        else {
            setError("Registration failed. Email or Password may already be in use.");
        }
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch(`${API_URL}/login`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({email, password})
        });

            if (response.ok) {
                const token = await response.text();
                localStorage.setItem("token", token);
                onLoginSuccess(token);
            }
            else {
                setError("Invalid email or password");
            }
    };

    return  (
    <div> 
        <h4 className="text-2xl font-bold text-gray-800 mb-6">{isRegistering ?"Register" : "Login"} </h4>
        <form onSubmit ={isRegistering ? handleRegister : handleSubmit} className="max-w-sm mx-auto bg-white p-6 rounded-lg shadow-md">
            <input
            type="email"
            placeholder = "Email"
            value = {email}
            onChange={(e) => setEmail(e.target.value)}
            />
            <input 
            type = "password"
            placeholder = "Password"
            value = {password}
            onChange ={(e) => setPassword(e.target.value)}
            />
            <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                {isRegistering ? "Register" : "Login"}
            </button>
        </form>
        <p onClick={() => setIsRegistering(!isRegistering)}
        className="cursor-pointer text-blue-500 hover:underline mt-4">
            {isRegistering ? "Already have an account? Login here." : "Don't have an account? Register here."}
        </p>
        {error && <p className="text-red-500 text-sm mt-2">{error}</p>}
    </div>
    );
}

export default LoginPage;