import { JSX } from "react";
import { useQuery } from "@tanstack/react-query";
import { Link } from "react-router-dom";
import { Badge, Box, Button, Grid, Group, Image, Paper, Stack, Text, Title } from "@mantine/core";
import { getWorlds, World } from "@/api/world_api";

function Dashboard() {
  return (
    <>
      <Stack gap="xl" justify="flex-start">
        <DashboardWorldList />
      </Stack>
    </>
  );
}

function DashboardWorldList(): JSX.Element {
  const query = useQuery({ queryKey: ["all-worlds"], queryFn: getWorlds });

  if (query.isLoading) {
    return <div>Loading...</div>;
  }

  function worldElementMap() {
    return query.data?.map(
      (world: World): JSX.Element => (
        <Grid.Col span={12}>
          <Paper shadow="sm" withBorder p="1rem">
            <Stack>
              <Title order={2}>{world.worldName}</Title>
              <Group gap="xs" justify="flex-start">
                <Box>
                  <Image
                    src="https://raw.githubusercontent.com/mantinedev/mantine/master/.demo/images/bg-8.png"
                    height="250rem"
                    fit="contain"
                    alt="Norway"
                    radius="sm"
                  />
                </Box>
                <Badge color="orange">Owner</Badge>
              </Group>
              <Box mih="5rem">
                <Title order={4}>World Description:</Title>
                <Text size="sm" c="dimmed">
                  {world.worldDesc}
                </Text>
              </Box>
              <Link to={`/worlds/edit/${world.worldID}`} style={{ textDecoration: "none" }}>
                <Button color="blue" fullWidth mt="md" radius="md">
                  View {world.worldName}
                </Button>
              </Link>
            </Stack>
          </Paper>
        </Grid.Col>
      )
    );
  }

  return (
    <>
      <Title order={1}>Your Worlds</Title>
      <Grid gutter="xl">{worldElementMap()}</Grid>
    </>
  );
}

export default Dashboard;
