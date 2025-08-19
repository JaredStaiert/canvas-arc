import { QueryFunctionContext } from "@tanstack/react-query";

const WORLD_URL = `${import.meta.env.VITE_SERVER_URL}worlds/`;

export type World = {
    worldID: number,
    dateCreated: Date,
    worldName: string,
    worldDesc: string
}

export async function getWorlds(): Promise<World[]> {
    const response = await fetch(`${WORLD_URL}all-worlds`, { credentials: "include" });
    if (!response.ok) {
        throw new Error(response.statusText);
    }
    return response.json();
}

export async function getWorldToEditById(
    { queryKey }: QueryFunctionContext<[string, { worldID: string | undefined}]>
): Promise<World> {
    const [_key, { worldID }] = queryKey;

    const response = await fetch(`${WORLD_URL}edit/get/${worldID}`, { credentials: "include" });
    if (!response.ok) {
        throw new Error(response.statusText);
    }
    return response.json();
}