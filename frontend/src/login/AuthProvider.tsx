import React, { createContext, useContext, useEffect, useState, ReactNode } from "react";
import { Button, Group, Paper, Flex } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import { getAuth } from "@/api/auth_api";

export interface AuthUser {
    email?: string;
    name?: string;
    [key: string]: any;
}

export interface AuthContextType {
    user: AuthUser | null;
    isLoading: boolean;
    login: () => void;
    logout: () => void;
    demo: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
    const [user, setUser] = useState<AuthUser | null>(null);

    const { isLoading, isError, data, error } = useQuery({
        queryKey: ["auth"],
        queryFn: getAuth,
        retry: false
    });


    useEffect(() => {
        if (!isLoading && !isError) {
            setUser(data);
        }
    }, [isLoading, isError, data]);

    const login = () => {
        return (window.location.href = "https://localhost:8443/oauth2/authorization/auth0-confidential-user");
    };

    const logout = () => {
        setUser(null);
        return (window.location.href = "https://localhost:8443/logout");
    };

    const demo = () => {
        return (window.location.href = "https://localhost:8443/auth/demo");
    }

    return (
        <AuthContext.Provider value={{ user, login, logout, isLoading, demo }}>
            { children }
        </AuthContext.Provider>
    );
}

export function LandingPage({ children }: { children: ReactNode }) {
    const { user, isLoading, login, logout, demo } = useAuth();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (!user) {
        return (
            <div style={{ display: "flex", height: "100vh", alignItems: "center", justifyContent: "center" }}>
                <div>
                    <h2>Welcome to the Application!</h2>
                    <Paper
                        shadow="xl"
                        radius="md"
                        p="xl"
                        withBorder>

                        <Flex
                            gap="md"
                            justify="center"
                            align="center"
                            direction="column"
                            wrap="wrap">

                                <Button
                                    variant="filled"
                                    color="green"
                                    onClick={demo}
                                >I'm Here to Demo the App!</Button>
                            <Group
                                justify="center"
                                gap="xl">

                                <Button variant="outline" onClick={login}>Login</Button>
                                <Button variant="outline" onClick={logout}>Logout</Button>
                            </Group>
                        </Flex>
                    </Paper>
                </div>
            </div>
        );
    }

    return <>{children}</>;
}

export function useAuth(): AuthContextType {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error("useAuth must be used in a child of AuthProvider");
    }
    return context;
}