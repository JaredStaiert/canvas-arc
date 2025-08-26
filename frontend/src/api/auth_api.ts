const AUTH_URL = `${import.meta.env.VITE_SERVER_URL}auth/`;

export async function getAuth() {
    const response = await fetch(`${AUTH_URL}me`, { credentials: "include" });
    if (!response.ok) {
        throw new Error(response.statusText);
    }
    return response.json();
}