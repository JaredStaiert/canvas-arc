import { useQuery } from "@tanstack/react-query";
import { getCharacters } from "@/api/character_api";
import { Badge, Group, Table } from "@mantine/core";

function CharTable() {

    const query = useQuery({ queryKey: ["all-characters"], queryFn: getCharacters });

    if (query.isLoading) {
        console.log("data loading");
    }

    const rows = query.data?.map((char, index) => (
        <Table.Tr key={index + char.characterName}>
            <Table.Td>{char.characterId}</Table.Td>
            <Table.Td>{char.userName}</Table.Td>
            <Table.Td>{char.characterName}</Table.Td>
            <Table.Td>{char.characterAge}</Table.Td>
            <Table.Td>
                <Group
                    gap="xs"
                >
                    {char.timelineName.split(",").map((str, index) => (
                        <Badge
                            key={index + char.timelineName}
                            color="green"
                            radius="sm"
                        >{str}</Badge>
                    ))}
                </Group>
            </Table.Td>
            <Table.Td>{char.worldName}</Table.Td>
            <Table.Td>{char.characterBio}</Table.Td>
        </Table.Tr>

    ))

    return (
        <>
            <Table>
                <Table.Thead>
                    <Table.Tr>
                        <Table.Th>ID</Table.Th>
                        <Table.Th>User Name</Table.Th>
                        <Table.Th>Character Name</Table.Th>
                        <Table.Th>Age</Table.Th>
                        <Table.Th>Timeline</Table.Th>
                        <Table.Th>World</Table.Th>
                        <Table.Th>Bio</Table.Th>
                    </Table.Tr>
                </Table.Thead>
                <Table.Tbody>{rows}</Table.Tbody>
            </Table>
        </>
    );

}

export default CharTable;