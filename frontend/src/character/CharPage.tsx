import React, { JSX, useState } from "react";
import {
  Button,
  Container,
  Fieldset,
  Flex,
  Grid,
  Group,
  Paper,
  Tabs,
  TextInput,
} from "@mantine/core";
import { CharacterDTO } from "@/api/character_api";
import DemoTextEditorComponent from "@/richText/DemoTextEditorComponent";

type Mode = "view" | "edit";

interface CharProps {
  character: CharacterDTO;
}

interface ModeStateProps {
  mode: string;
  setMode: React.Dispatch<React.SetStateAction<Mode>>;
}

interface BioProps extends CharProps, ModeStateProps {}

function CharPage({ character }: CharProps): JSX.Element {
  const [activeTab, setActiveTab] = useState<string | null>("biography");
  const [mode, setMode] = useState<Mode>("view");

  return (
    <>
      <Flex justify="flex-start">
        <Tabs
          radius="xs"
          orientation="vertical"
          defaultValue="gallery"
          value={activeTab}
          onChange={setActiveTab}
          w="75rem"
          h="40rem"
        >
          <Tabs.List>
            <Tabs.Tab value="biography">Biography</Tabs.Tab>
            <Tabs.Tab value="events">Events</Tabs.Tab>
            <Tabs.Tab value="settings">Settings</Tabs.Tab>
          </Tabs.List>

          <Tabs.Panel value="biography">
            <CharToolBar mode={mode} setMode={setMode} />
            <BioSection character={character} mode={mode} setMode={setMode} />
          </Tabs.Panel>

          <Tabs.Panel value="events">
            <CharPageEvents />
          </Tabs.Panel>

          <Tabs.Panel value="settings">Settings tab content</Tabs.Panel>
        </Tabs>
      </Flex>
    </>
  );
}

/**
 * Toolbar that renders the save button and conditionally edit / stop editing
 * buttons.
 * @param mode Current state.
 * @param setMode Setter function for state.
 */
function CharToolBar({ mode, setMode }: ModeStateProps): JSX.Element {
  function renderButton() {
    switch (mode) {
      case "view":
        return (
          <Button variant="default" onClick={() => setMode("edit")}>
            Edit
          </Button>
        );
      case "edit":
        return (
          <Button variant="default" onClick={() => setMode("view")}>
            Finish
          </Button>
        );
      default:
        return <Button variant="default">Edit</Button>;
    }
  }

  return (
    <>
      <Paper shadow="xs">
        <Container>
          <Group>
            {renderButton()}
            <Button variant="default">Save</Button>
          </Group>
        </Container>
      </Paper>
    </>
  );
}

function BioSection({ character, mode }: BioProps): JSX.Element {
  function bioRenderSwitch() {
    switch (mode) {
      case "view":
        return <BioSectionView character={character} />;
      case "edit":
        return <BioSectionEdit character={character} />;
      default:
        return <>Error</>;
    }
  }

  return (
    <>
      <Grid grow gutter="xl" p="xl">
        {bioRenderSwitch()}
        <Grid.Col span={12}>
          <DemoTextEditorComponent />
        </Grid.Col>
      </Grid>
    </>
  );
}

function BioSectionView({ character }: CharProps): JSX.Element {
  return (
    <>
      <Grid.Col span={6}>
        <TextInput
          label="Name"
          value={character.characterName}
          style={{ pointerEvents: "none" }}
          readOnly
        />
      </Grid.Col>
      <Grid.Col span={6}>
        <TextInput
          label="Age"
          value={String(character.characterAge)}
          style={{ pointerEvents: "none" }}
          readOnly
        />
      </Grid.Col>
      <Grid.Col span={6}>
        <TextInput
          label="Owner"
          value={character.userName}
          style={{ pointerEvents: "none" }}
          readOnly
        />
      </Grid.Col>
    </>
  );
}

function BioSectionEdit({ character }: CharProps): JSX.Element {
  return (
    <>
      <Grid.Col span={6}>
        <Fieldset variant="unstyled">
          <TextInput label="Name" placeholder={character.characterName} />
        </Fieldset>
      </Grid.Col>
      <Grid.Col span={6}>
        <Fieldset variant="unstyled">
          <TextInput label="Age" placeholder={String(character.characterAge)} />
        </Fieldset>
      </Grid.Col>
      <Grid.Col span={6}>
        <Fieldset variant="unstyled">
          <TextInput label="Ownser" placeholder={character.userName} />
        </Fieldset>
      </Grid.Col>
    </>
  );
}

function CharPageEvents() {
  return (
    <>
      <Grid grow gutter="xl" p="xl">
        <p>Event</p>
      </Grid>
    </>
  );
}

export default CharPage;
