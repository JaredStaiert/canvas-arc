import { UnstyledButton } from "@mantine/core";
import { useAuth } from "@/login/AuthProvider";

function LogoutButton() {
    const { logout } = useAuth();

    return (
        <>
            <UnstyledButton
                onClick={logout}
            >Logout</UnstyledButton>
        </>
    );
}

export default LogoutButton;