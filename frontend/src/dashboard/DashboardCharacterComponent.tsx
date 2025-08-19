import { Badge, Button, Card, Flex, Group, Text } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import { getCharacters } from "@/api/character_api";

function DashboardCharacterComponent() {

    const query = useQuery({ queryKey: ["all-characters"], queryFn: getCharacters });

    return (
        <>
            <Flex
                mih={50}
                gap="xl"
                justify="center"
                align="center"
                direction="column"
                wrap="wrap"
            >
            {query.data?.map((character) => (
                    <Card
                        shadow="sm"
                        padding="lg"
                        radius="md"
                        withBorder key={character.characterName}
                    >
                        <Card.Section>
                            <p>IMG HERE</p>
                        </Card.Section>
                        <Group justify="space-between" mt="md" mb="xs">
                            <Text fw={500}>{character.characterName}</Text>
                            <Badge color="pink">On Sale</Badge>
                        </Group>

                        <Text size="sm" c="dimmed">
                            {character.characterBio}
                        </Text>

                        <Button color="blue" fullWidth mt="md" radius="md">
                            Character
                        </Button>
                    </Card>
                ))}
            </Flex>
        </>
    );
}

export default DashboardCharacterComponent;